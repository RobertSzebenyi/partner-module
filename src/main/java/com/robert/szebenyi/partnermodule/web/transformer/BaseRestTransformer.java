package com.robert.szebenyi.partnermodule.web.transformer;


import com.robert.szebenyi.partnermodule.web.dto.Response;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public abstract class BaseRestTransformer<F, T> {

    public Response<T> transformToResponse(F from) {
        return new Response<>(transform(from));
    }

    public Response<List<T>> transformToResponseList(List<F> fromList) {

        if (fromList == null) {
            return new Response<>(new ArrayList<>());
        }

        return new Response<>(fromList.stream().map(this::transform).collect(toList()));

    }

    abstract public T transform(F from);

    public List<T> transformList(List<F> fromList) {

        if (fromList == null) {
            return new ArrayList<>();
        }

        return fromList.stream().map(this::transform).collect(toList());

    }

}
