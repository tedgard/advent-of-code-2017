package day4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.PuzzleInputReader;

import java.util.Arrays;
import java.util.List;

public class PassphraseSolverTest {

    private PassphraseSolver solver;
    private PuzzleInputReader puzzleInputReader;
    private List<String> passphrases;

    @Before
    public void setUp() throws Exception {
        solver = new PassphraseSolver();
        puzzleInputReader = new PuzzleInputReader();
    }

    @Test
    public void shouldFindValidPassphrasesBasedOnWordFrequency_SimpleCase(){
        passphrases = Arrays.asList("aa bb cc dd ee", "aa bb cc dd aa", "aa bb cc dd aaa");
        Assert.assertEquals(2, solver.solveOnWordFrequencyBasis(passphrases));
    }

    @Test
    public void shouldFindValidPassphrasesBasedOnWordFrequency_ComplexCase(){
        passphrases = puzzleInputReader.readInputForPuzzle("day-4-input");
        Assert.assertEquals(466, solver.solveOnWordFrequencyBasis(passphrases));
    }

    @Test
    public void shouldFindValidPassphrasesBasedOnWordFrequencyAndAnagramNonexistent_SimpleCase(){
        passphrases = Arrays.asList("abcde fghij", "abcde xyz ecdab", "a ab abc abd abf abj", "iiii oiii ooii oooi oooo", "oiii ioii iioi iiio");
        Assert.assertEquals(3, solver.solveOnWordFrequencyAndOnAnagramBasis(passphrases));
    }

    @Test
    public void shouldFindValidPassphrasesBasedOnWordFrequencyAndAnagramNonexistent_ComplexCase(){
        passphrases = puzzleInputReader.readInputForPuzzle("day-4-input");
        Assert.assertEquals(251, solver.solveOnWordFrequencyAndOnAnagramBasis(passphrases));
    }

}