package com.eason.magictriangle.domain;

import java.util.Objects;

public enum TriangleType {
    EQUILATERAL("等边三角形") {
        @Override
        public boolean isCurrentType(Triangle triangle) {
            return Objects.equals(triangle.getSides().getValue0(), triangle.getSides().getValue1())
                    && Objects.equals(triangle.getSides().getValue1(), triangle.getSides().getValue2());
        }
    },
    ISOSCELES("等腰三角形") {
        @Override
        public boolean isCurrentType(Triangle triangle) {
            return Objects.equals(triangle.getSides().getValue0(), triangle.getSides().getValue1());
        }
    },
    RIGHT("直角三角形") {
        @Override
        public boolean isCurrentType(Triangle triangle) {
            final int square = 2;
            return (Math.pow(triangle.getSides().getValue0(), square) +
                    Math.pow(triangle.getSides().getValue1(), square))
                    == Math.pow(triangle.getSides().getValue2(), square);
        }
    }, NORMAL("常规三角形");

    public final String typeName;

    TriangleType(String typeName) {
        this.typeName = typeName;
    }

    public boolean isCurrentType(Triangle triangle) {
        return triangle.getSides().getValue0() + triangle.getSides().getValue1() > triangle.getSides().getValue2();
    }
}
