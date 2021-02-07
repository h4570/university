package pl.edu.pjwstk.mpr.investment;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InvestmentTest {

    @Test
    public void should_create_investment() {
        Investment investment = new SimpleInvestment();
        assertThat(investment).isNotNull();
    }

    @Test
    public void should_buy_plot() throws WrongStateTransitionException {
        Investment investment = new SimpleInvestment();
        investment.buyPlot();
        assertThat(investment.getState()).isEqualTo(InvestmentState.PLOT_BOUGHT);
    }

    @Test
    public void should_buy_plot_bad() throws WrongStateTransitionException {
        Investment investment = new SimpleInvestment();
        investment.buyPlot();
        assertThatThrownBy(investment::buyPlot)
                .isInstanceOf(WrongStateTransitionException.class)
                .hasMessage("Plot can be bought only in conception phase!");
    }

    @Test
    public void should_sell_plot() throws WrongStateTransitionException {
        Investment investment = new SimpleInvestment();
        investment.buyPlot();
        investment.sellPlot();
        assertThat(investment.getState()).isEqualTo(InvestmentState.PLOT_SOLD);
    }

    @Test
    public void should_sell_plot_bad() {
        Investment investment = new SimpleInvestment();
        assertThatThrownBy(investment::sellPlot)
                .isInstanceOf(WrongStateTransitionException.class)
                .hasMessage("Plot can be sold only when was bought!");
    }

    @Test
    public void should_design() throws WrongStateTransitionException {
        Investment investment = new SimpleInvestment();
        investment.buyPlot();
        investment.design();
        assertThat(investment.getState()).isEqualTo(InvestmentState.DESIGN_PHASE);
    }

    @Test
    public void should_design_bad() {
        Investment investment = new SimpleInvestment();
        assertThatThrownBy(investment::design)
                .isInstanceOf(WrongStateTransitionException.class)
                .hasMessage("Design phase can be activated only when plot was bought!");
    }

    @Test
    public void should_release() throws WrongStateTransitionException {
        Investment investment = new SimpleInvestment();
        investment.buyPlot();
        investment.design();
        investment.build();
        investment.release();
        assertThat(investment.getState()).isEqualTo(InvestmentState.RELEASED);
    }

    @Test
    public void should_release_bad() {
        Investment investment = new SimpleInvestment();
        assertThatThrownBy(investment::release)
                .isInstanceOf(WrongStateTransitionException.class)
                .hasMessage("Cant release building, because it was not built!");
    }

    @Test
    public void should_build_investment() throws WrongStateTransitionException {
        Investment investment = new SimpleInvestment();
        investment.buyPlot();
        investment.design();
        investment.build();
        assertThat(investment.getState()).isEqualTo(InvestmentState.BUILT);
    }

    @Test
    public void should_build_investment_bad() {
        Investment investment = new SimpleInvestment();
        assertThatThrownBy(investment::build)
                .isInstanceOf(WrongStateTransitionException.class)
                .hasMessage("Cant build, because design phase was not done!");
    }

    @Test
    public void should_add_suggestion() throws WrongStateTransitionException, WrongStateSuggestionException {
        Investment investment = new SimpleInvestment();
        investment.buyPlot();
        investment.design();
        investment.newSuggestion("1", "test");
        assertThat(investment.getState()).isEqualTo(InvestmentState.DESIGN_PHASE);
    }

    @Test
    public void should_add_suggestion_bad() {
        Investment investment = new SimpleInvestment();
        assertThatThrownBy(() -> {
            investment.newSuggestion("1", "2");
        })
                .isInstanceOf(WrongStateSuggestionException.class)
                .hasMessage("Cant add new suggestion, because project is not in design phase!");
    }

    @Test
    public void should_resolve_suggestion() throws WrongStateTransitionException, WrongStateSuggestionException, SuggestionNotFoundException {
        Investment investment = new SimpleInvestment();
        investment.buyPlot();
        investment.design();
        var sug = investment.newSuggestion("1", "test");
        investment.resolveSuggestion(sug);
        assertThat(investment.getState()).isEqualTo(InvestmentState.DESIGN_PHASE);
    }

    @Test
    public void should_resolve_suggestion_bad_1() {
        Investment investment = new SimpleInvestment();
        var sug = new Suggestion("1", "test");
        assertThatThrownBy(() -> {
            investment.resolveSuggestion(sug);
        })
                .isInstanceOf(WrongStateSuggestionException.class)
                .hasMessage("Cant resolve suggestion, because project is not in design phase!");
    }

    @Test
    public void should_resolve_suggestion_bad_2() throws WrongStateTransitionException {
        Investment investment = new SimpleInvestment();
        investment.buyPlot();
        investment.design();
        var sug = new Suggestion("1", "test");
        assertThatThrownBy(() -> {
            investment.resolveSuggestion(sug);
        })
                .isInstanceOf(SuggestionNotFoundException.class)
                .hasMessage("Cant resolve suggestion, it was not added!");
    }

    @Test
    public void should_close_investment_1() throws WrongStateTransitionException {
        Investment investment = new SimpleInvestment();
        investment.closeInvestment();
        assertThat(investment.getState()).isEqualTo(InvestmentState.CLOSED);
    }

    @Test
    public void should_close_investment_2() throws WrongStateTransitionException {
        Investment investment = new SimpleInvestment();
        investment.buyPlot();
        investment.sellPlot();
        investment.closeInvestment();
        assertThat(investment.getState()).isEqualTo(InvestmentState.CLOSED);
    }

    @Test
    public void should_close_investment_bad() throws WrongStateTransitionException {
        Investment investment = new SimpleInvestment();
        investment.buyPlot();
        assertThatThrownBy(investment::closeInvestment)
                .isInstanceOf(WrongStateTransitionException.class)
                .hasMessage("Cant close investment, because project is not in design phase or plot was not sold!");
    }

}
