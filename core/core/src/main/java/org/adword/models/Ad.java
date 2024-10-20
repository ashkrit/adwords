package org.adword.models;

import java.net.URL;
import java.time.LocalDateTime;

public record Ad(String id, String headLine, String desc, URL url, LocalDateTime created, LocalDateTime updated) {
}
