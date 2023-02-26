package model;

import util.GameStrategy;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {
    private Map<Name, Goal> prizeResult;

    public Game(Names names, LadderGoal goal, Ladder ladder, GameStrategy gameStrategy) {
        prizeResult = convertPrize(gameStrategy.playGame(ladder),
                names, goal);
    }

    private Map<Name, Goal> convertPrize(Map<Integer, Integer> prize, Names names, LadderGoal goal) {
        return prize.entrySet()
                .stream()
                .collect(Collectors.toUnmodifiableMap(
                        entry -> names.getName(entry.getKey()),
                        entry -> goal.getGoal(entry.getValue())
                ));
    }

    public String getPrizeIndividualWinner(Winner name) {
        return prizeResult.get(new Name(name.getWinner())).getGoal();
    }

    public Map<Name, Goal> getPrizeWinners() {
        return Collections.unmodifiableMap(prizeResult);
    }

    public Goal getGameGoal(Name name) {
        return prizeResult.get(name);
    }

}
