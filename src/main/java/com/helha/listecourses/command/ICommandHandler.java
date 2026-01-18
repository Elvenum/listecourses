package com.helha.listecourses.command;

// TInput = ce qui entre (ex: CreateProductInput)
// TOutput = ce qui sort (ex: Product)
public interface ICommandHandler<TInput, TOutput> {
    TOutput handle(TInput input);
}