package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.CoordinatesDto;
import com.airlines.yourairlines.entity.Airport;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static java.lang.Math.*;

@Service
public class MapService implements IMapService {

    private static final double EARTH_RADIUS = 6371.; // Радиус Земли

    private static String encodeParams(final Map<String, String> params) {
        final String paramsUrl = Joiner.on('&').join(// получаем значение вида key1=value1&key2=value2...
                Iterables.transform(params.entrySet(), new Function<Map.Entry<String, String>, String>() {
                    @Override
                    public String apply(final Map.Entry<String, String> input) {
                        String buffer = input.getKey() +// получаем значение вида key=value
                                '=' +
                                URLEncoder.encode(input.getValue(), StandardCharsets.UTF_8);// кодируем строку в соответствии со стандартом HTML 4.01
                        return buffer;
                    }
                }));
        return paramsUrl;
    }

    /**
     * Преобразует значение из градусов в радианы
     *
     * @param degree градусы
     * @return радианы
     */
    private static double deg2rad(final Double degree) {
        return degree * (Math.PI / 180);
    }

    public CoordinatesDto geoCoding(String address) {
        final String baseUrl = "https://nominatim.openstreetmap.org/search";// путь к Geocoding API по HTTP
        final Map<String, String> params = Maps.newHashMap();
        params.put("q", address);
        params.put("limit", "1");
        params.put("format", "json");
        final String url = baseUrl + '?' + encodeParams(params);// генерируем путь с параметрами
        RestTemplate restTemplate = new RestTemplate();
        String coordinatesString = restTemplate.getForObject(url, String.class);
        assert coordinatesString != null;
        String coordinatesStringWithoutSlash = coordinatesString.replaceAll("\"", "");
        String[] strings = coordinatesStringWithoutSlash.split(",");
        Optional<String> optionalLon = Arrays.stream(strings).filter(s -> s.contains("lon:")).map((s -> s.split(":"))).map((s -> s[1])).findFirst();
        Optional<String> optionalLat = Arrays.stream(strings).filter(s -> s.contains("lat:")).map((s -> s.split(":"))).map((s -> s[1])).findFirst();
        String lon = optionalLon.orElse("0");
        String lat = optionalLat.orElse("0");

        return new CoordinatesDto(Double.valueOf(lat), Double.valueOf(lon));// итоговая широта и долгота
    }

    public String geoDecoding(String lat, String lon) {
        final String baseUrl = "https://nominatim.openstreetmap.org/reverse";// путь к Geocoding API по HTTP
        final Map<String, String> params = Maps.newHashMap();
        params.put("format", "json");
        params.put("accept-language", "ru");
        params.put("lat", lat);
        params.put("lon", lon);
        final String url = baseUrl + '?' + encodeParams(params);// генерируем путь с параметрами
        RestTemplate restTemplate = new RestTemplate();
        String addressString = restTemplate.getForObject(url, String.class);
        JSONObject addressJSON = new JSONObject(addressString);
        return addressJSON.getString("display_name");
    }

    public Double calcDistanceBetweenPoints(String departureAddress, String arrivalAddress) {
        final CoordinatesDto arrivalAddressCoordinates = geoCoding(arrivalAddress);
        final CoordinatesDto departureAddressCoordinates = geoCoding(departureAddress);

        // Рассчитываем расстояние между точками
        final Double dlng = deg2rad(arrivalAddressCoordinates.lon - departureAddressCoordinates.lon);
        final Double dlat = deg2rad(arrivalAddressCoordinates.lat - departureAddressCoordinates.lat);
        final Double a = sin(dlat / 2) * sin(dlat / 2) + cos(deg2rad(departureAddressCoordinates.lat))
                * cos(deg2rad(arrivalAddressCoordinates.lat)) * sin(dlng / 2) * sin(dlng / 2);
        final Double c = 2 * atan2(sqrt(a), sqrt(1 - a));
        return c * EARTH_RADIUS; // получаем расстояние в километрах
    }

    @Override
    public Double calcDistanceBetweenPoints(Airport departureAirport, Airport arrivalAirport) {
        final CoordinatesDto arrivalAddressCoordinates = new CoordinatesDto(Double.valueOf(arrivalAirport.getLat()), Double.valueOf(arrivalAirport.getLon()));
        final CoordinatesDto departureAddressCoordinates = new CoordinatesDto(Double.valueOf(departureAirport.getLat()), Double.valueOf(departureAirport.getLon()));

        // Рассчитываем расстояние между точками
        final Double dlng = deg2rad(arrivalAddressCoordinates.lon - departureAddressCoordinates.lon);
        final Double dlat = deg2rad(arrivalAddressCoordinates.lat - departureAddressCoordinates.lat);
        final Double a = sin(dlat / 2) * sin(dlat / 2) + cos(deg2rad(departureAddressCoordinates.lat))
                * cos(deg2rad(arrivalAddressCoordinates.lat)) * sin(dlng / 2) * sin(dlng / 2);
        final Double c = 2 * atan2(sqrt(a), sqrt(1 - a));
        return c * EARTH_RADIUS; // получаем расстояние в километрах
    }
}
