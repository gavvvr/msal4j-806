package org.example.lib;

public class Builder extends AbstractBuilder<Builder> {
    @Override
    Builder self() {
        return this;
    }
}

abstract class AbstractBuilder<T extends AbstractBuilder<T>> /*extends BuilderBase<T>*/ {
    public T executorService() {
        return self();
    }

    abstract T self();
}

abstract class BuilderBase<T extends BuilderBase<T>> {
    public T executorService() {
        return self();
    }

    abstract T self();
}
