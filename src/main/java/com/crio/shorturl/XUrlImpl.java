package com.crio.shorturl;
import java.util.HashMap;
import java.util.Map;

public class XUrlImpl implements XUrl {

    public Map<String, String> longToShortUrlMap;
    private Map<String, Integer> longUrlHitCountMap;
    private Generator generator = new Generator();

    public XUrlImpl() {
        this.longToShortUrlMap = new HashMap<>();
        this.longUrlHitCountMap = new HashMap<>();
    }

    @Override
    public String registerNewUrl(String longUrl) {
        if (longToShortUrlMap.containsKey(longUrl)) {
            return longToShortUrlMap.get(longUrl);
        }
        // method for generating short url...
        String shorturl = "http://short.url/" + generator.generate();
        longToShortUrlMap.put(longUrl, shorturl);
        longUrlHitCountMap.put(longUrl, 0);
        return shorturl;
    }

    @Override
    public String registerNewUrl(String longUrl, String shortUrl) {
        if (longToShortUrlMap.containsValue(shortUrl)) {
            return null;
        } else {
            longToShortUrlMap.put(longUrl, shortUrl);
            longUrlHitCountMap.put(longUrl, 0);
            return shortUrl;
        }
    }

    @Override
    public String getUrl(String shortUrl) {
        for (Map.Entry<String, String> entry : longToShortUrlMap.entrySet()) {
            if (entry.getValue().equals(shortUrl)) {
              longUrlHitCountMap.put(entry.getKey(), longUrlHitCountMap.get(entry.getKey()) + 1);
              return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public Integer getHitCount(String longUrl) {
        return longUrlHitCountMap.getOrDefault(longUrl, 0);
    }

    @Override
    public String delete(String longUrl) {
        String shortUrl = longToShortUrlMap.remove(longUrl);
        longUrlHitCountMap.remove(longUrl);
        return shortUrl;
    }

}