package com.wilutions.byps.test.api.inl;

import java.io.Serializable;

/**
 * Example for an inline class.
 * Final classes cannot be evolved or derived.
 * Objects of final classes are serialized without 
 * the overhead of type and reference information. 
 * This optimization is especially useful in the case of 
 * large arrays of small objects being serialized.
 * @inline
 */
public class Point2D implements Serializable {

    public short x, y;

    private static final long serialVersionUID = -8219093741447648468L;

}
