/* Author: Sandro Sobczyński */

package com.company;

public class WrongTermException extends Exception {

    private static final long serialVersionUID = -8358974557332672645L;

    public WrongTermException(final String message) {
        super(message);
    }
}
