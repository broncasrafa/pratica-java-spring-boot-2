package com.rsfrancisco.springbootmongodb.domain.utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Helpers {

    public static URI getURI(String path, Object id) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(path).buildAndExpand(id).toUri();
        return uri;
    }

    public static Instant getDateTimeNow() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Instant datetime = Timestamp.valueOf(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).toInstant();
        return datetime;
    }

}
