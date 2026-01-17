package com.helha.listecourses.application.utils;

public interface IQueryHandler<I, O> {
    O handle( I input);
}
