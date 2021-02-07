/* Author: Sandro Sobczyński */

package com.company;

import java.util.Locale;

public class ChemicalElement {

    private String name;
    private String symbolicName;
    private int atomicNumber;
    private ChemicalElementType type;

    public ChemicalElement(String name, String symbolicName, int atomicNumber) {
        this.name = name;
        this.symbolicName = symbolicName;
        this.atomicNumber = atomicNumber;
        this.type = ChemicalElementTypeHelpers.getChemicalElementTypeFromAtomicNumber(this.atomicNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getSymbolicName() {
        return symbolicName;
    }

    public void setSymbolicName(String value) {
        this.symbolicName = value;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public boolean isAlkali() {
        return type == ChemicalElementType.Alkali;
    }

    public boolean isMetal() {
        return type == ChemicalElementType.Metal;
    }

    public boolean isTransitionMetal() {
        return type == ChemicalElementType.TransitionMetal;
    }

    public String toString() {
        String typeInString;
        switch (this.type) {
            case Alkali: typeInString="alkali"; break;
            case TransitionMetal: typeInString="metal"; break;
            case Metal: typeInString="transition metal"; break;
            default: typeInString = "unknown"; break;
        }
        return String.format(Locale.US, "%s: %s with atomic number %d. It is a %s metal", symbolicName, name,
                atomicNumber, typeInString);
    }

}
