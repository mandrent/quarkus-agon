package io.oneo.agon.modules.usuario.type;

public enum StatusUsuarioTipo
{
    ATIVO,
    INATIVO,
    PENDENTE;

    public static StatusUsuarioTipo validate(int ordinal)
    {
        return switch (ordinal) {
            case 1 -> StatusUsuarioTipo.ATIVO;
            case 2 -> StatusUsuarioTipo.INATIVO;
            default -> StatusUsuarioTipo.PENDENTE;
        };
    }
}