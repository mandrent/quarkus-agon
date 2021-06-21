package io.oneo.agon.modules.profissional.service;

import io.oneo.agon.modules.profissional.model.Profissional;

import java.util.Optional;

public interface IProfissionalService
{
    Optional<Profissional> findByDocuments(Profissional profissional);
}