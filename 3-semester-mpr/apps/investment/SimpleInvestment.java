package pl.edu.pjwstk.mpr.investment;

import java.util.ArrayList;

public class SimpleInvestment implements Investment {

    private InvestmentState state;
    private ArrayList<Suggestion> unresolvedSuggestions;
    private ArrayList<Suggestion> resolvedSuggestions;

    public SimpleInvestment() {
        state = InvestmentState.CONCEPTION;
        unresolvedSuggestions = new ArrayList<>();
        resolvedSuggestions = new ArrayList<>();
    }

    @Override
    public void buyPlot() throws WrongStateTransitionException {
        if (state != InvestmentState.CONCEPTION)
            throw new WrongStateTransitionException("Plot can be bought only in conception phase!");
        state = InvestmentState.PLOT_BOUGHT;
    }

    @Override
    public void sellPlot() throws WrongStateTransitionException {
        if (state != InvestmentState.PLOT_BOUGHT)
            throw new WrongStateTransitionException("Plot can be sold only when was bought!");
        state = InvestmentState.PLOT_SOLD;
    }

    @Override
    public void design() throws WrongStateTransitionException {
        if (state != InvestmentState.PLOT_BOUGHT)
            throw new WrongStateTransitionException("Design phase can be activated only when plot was bought!");
        state = InvestmentState.DESIGN_PHASE;
    }

    @Override
    public void release() throws WrongStateTransitionException {
        if (state != InvestmentState.BUILT)
            throw new WrongStateTransitionException("Cant release building, because it was not built!");
        state = InvestmentState.RELEASED;
    }

    @Override
    public void build() throws WrongStateTransitionException {
        if (state != InvestmentState.DESIGN_PHASE)
            throw new WrongStateTransitionException("Cant build, because design phase was not done!");
        state = InvestmentState.BUILT;
    }

    @Override
    public Suggestion newSuggestion(String id, String suggestion) throws WrongStateSuggestionException {
        if (state != InvestmentState.DESIGN_PHASE)
            throw new WrongStateSuggestionException("Cant add new suggestion, because project is not in design phase!");
        var itm = new Suggestion(id, suggestion);
        unresolvedSuggestions.add(itm);
        return itm;
    }

    @Override
    public void resolveSuggestion(Suggestion suggestion) throws WrongStateSuggestionException, SuggestionNotFoundException {
        if (state != InvestmentState.DESIGN_PHASE)
            throw new WrongStateSuggestionException("Cant resolve suggestion, because project is not in design phase!");
        if (unresolvedSuggestions.indexOf(suggestion) < 0)
            throw new SuggestionNotFoundException("Cant resolve suggestion, it was not added!");
        resolvedSuggestions.add(suggestion);
        unresolvedSuggestions.remove(suggestion);
    }

    @Override
    public void closeInvestment() throws WrongStateTransitionException {
        if (state != InvestmentState.CONCEPTION && state != InvestmentState.PLOT_SOLD)
            throw new WrongStateTransitionException("Cant close investment, because project is not in design phase or plot was not sold!");
        state = InvestmentState.CLOSED;
    }

    @Override
    public InvestmentState getState() {
        return state;
    }

}

class WrongStateSuggestionException extends Exception {
    public WrongStateSuggestionException(String message) {
        super(message);
    }
}

class WrongStateTransitionException extends Exception {
    public WrongStateTransitionException(String message) {
        super(message);
    }
}

class SuggestionNotFoundException extends Exception {
    public SuggestionNotFoundException(String message) {
        super(message);
    }
}
