/* Author: Sandro Sobczyński */

package com.company;

public class ChemicalElementTypeHelpers {

    public static ChemicalElementType getChemicalElementTypeFromAtomicNumber(int atomicNumber) {
        switch (atomicNumber) {
            case 3:  return ChemicalElementType.Alkali;
            case 11: return ChemicalElementType.Alkali;
            case 19: return ChemicalElementType.Alkali;
            case 37: return ChemicalElementType.Alkali;
            case 55: return ChemicalElementType.Alkali;
            case 87: return ChemicalElementType.Alkali;
            case 13: return ChemicalElementType.Metal;
            case 49: return ChemicalElementType.Metal;
            case 50: return ChemicalElementType.Metal;
            case 81: return ChemicalElementType.Metal;
            case 82: return ChemicalElementType.Metal;
            case 83: return ChemicalElementType.Metal;
            case 113: return ChemicalElementType.Metal;
            case 114: return ChemicalElementType.Metal;
            case 115: return ChemicalElementType.Metal;
        }

        if (21 <= atomicNumber && atomicNumber <= 31 || 39 <= atomicNumber && atomicNumber <= 48
                || 72 <= atomicNumber && atomicNumber <= 80 || 104 <= atomicNumber && atomicNumber <= 112) {
            return ChemicalElementType.TransitionMetal;
        }

        return ChemicalElementType.Unknown;
    }

}
