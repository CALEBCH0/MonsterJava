package com.monster.utils;

public class Translation2d {
    private final double x_;
    private final double y_;

    public Translation2d() {
        x_ = 0;
        y_ = 0;
    }

    public Translation2d(double x, double y) {
        x_ = x;
        y_ = y;
    }

    public Translation2d(final Translation2d other) {
        x_ = other.x_;
        y_ = other.y_;
    }

    public Translation2d (final Translation2d start, final Translation2d end) {
        x_ = end.x_ - start.x_;
        y_ = end.y_ - start.y_;
    }


    public double x() {
        return x_;
    }

    public double y() {
        return y_;
    }
}