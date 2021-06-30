package io.oneo.agon.modules.usuario.type;

public enum GrupoTipo
{
    ADMIN,
    CONVIDADO,
    EMPRESA,
    PROFISSIONAL;

    public static GrupoTipo validate(int ordinal)
    {
        return switch (ordinal) {
            case 1 -> GrupoTipo.ADMIN;
            case 2 -> GrupoTipo.CONVIDADO;
            case 3 -> GrupoTipo.EMPRESA;
            default -> GrupoTipo.PROFISSIONAL;
        };
    }
}