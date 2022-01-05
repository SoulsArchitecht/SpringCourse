package ru.sendel.pastebox.api.request;

import lombok.Data;
import ru.sendel.pastebox.api.PublicStatus;

@Data
public class PasteBoxRequest {
    private String data;
    private long expirationTimeSeconds;
    private PublicStatus publicStatus;

}
