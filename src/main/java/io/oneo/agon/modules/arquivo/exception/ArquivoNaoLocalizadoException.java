package io.oneo.agon.modules.arquivo.exception;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ArquivoNaoLocalizadoException extends FileNotFoundException
{
    public ArquivoNaoLocalizadoException(String message) { super(message); }

    @Override
    public void printStackTrace(PrintStream s)
    {
        super.printStackTrace(s);
    }

}