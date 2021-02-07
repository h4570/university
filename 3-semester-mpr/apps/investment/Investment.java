package pl.edu.pjwstk.mpr.investment;

public interface Investment {

    void build() throws WrongStateTransitionException;

    void buyPlot() throws WrongStateTransitionException;

    void sellPlot() throws WrongStateTransitionException;

    void design() throws WrongStateTransitionException;

    void release() throws WrongStateTransitionException;

    Suggestion newSuggestion(String id, String suggestion) throws WrongStateSuggestionException;

    void resolveSuggestion(Suggestion suggestion) throws WrongStateSuggestionException, SuggestionNotFoundException;

    void closeInvestment() throws WrongStateTransitionException;

    InvestmentState getState();

}