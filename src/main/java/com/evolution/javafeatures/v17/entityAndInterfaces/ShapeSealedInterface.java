package com.evolution.javafeatures.v17.entityAndInterfaces;

// Sealed classes and interfaces restrict which other classes or interfaces can extend or implement them.
public sealed interface ShapeSealedInterface permits Circle {
}
