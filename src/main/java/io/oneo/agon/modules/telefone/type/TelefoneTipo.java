package io.oneo.agon.modules.telefone.type;

public enum TelefoneTipo
{
    CELULAR,
    COMERCIAL,
    RESIDENCIAL;

    public static TelefoneTipo validate(Integer type)
    {
        return switch (type) {
            case 1 -> CELULAR;
            case 2 -> COMERCIAL;
            default -> RESIDENCIAL;
        };
    }
}