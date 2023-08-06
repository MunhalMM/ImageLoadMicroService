package com.mosy.imageloadproject.imagetype;

public enum ImageType {
    JPEG(".jpeg"),
    PNG(".png"),
    ICO(".ico"),
    GIF(".gif"),
    TIFF(".tiff"),
    WebP(".webp"),
    EPS(".eps"),
    SVG(".svg"),
    PSD(".psd"),
    INDD(".indd"),
    CDR(".cdr"),
    AI(".ai"),
    RAW(".raw");

    private final String name;

    ImageType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
