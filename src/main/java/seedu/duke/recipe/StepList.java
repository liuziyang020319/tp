package seedu.duke.recipe;

import java.util.ArrayList;
import seedu.duke.ui.UI;

public class StepList {
    protected ArrayList<Step> stepList;
    protected int currStepNumber;
    UI ui = new UI();
    /**
     * Class constructor without arguments.
     */
    public StepList() {
        stepList = new ArrayList<>();
        currStepNumber = 0;
    }
    /**
     * Class constructor with argument. An existing array list of steps
     * is used as the argument
     *
     * @param stepList - list of all steps in the recipe.
     */
    public StepList(ArrayList<Step> stepList) {
        this.stepList = stepList;
        currStepNumber = stepList.size();
    }
    private void addStep(Step step) {
        stepList.add(step);
        currStepNumber++;
        assert (currStepNumber == stepList.size());
    }
    private void removeStep(int stepIndex) {
        stepList.remove(stepIndex - 1);
        currStepNumber--;
        assert (currStepNumber == stepList.size());
    }
    public void showStepList() {
        System.out.println("There are " + currStepNumber + " steps in the list");
        System.out.println("Do you want to view step-by-step? \nType yes if so");

        if (ui.readCommand().toLowerCase().equals("yes")) {
            System.out.println("If you would like to exit the recipe view, type \"quit\"");
            System.out.println("Otherwise, enter any key to continue to the next step");
            String input = "";
            for (int i = 0; (!input.equals("quit") && i < currStepNumber); i++) {
                System.out.println((i + 1) + ". " + stepList.get(i).getStep());
                while (i <= currStepNumber - 1) {
                    input = ui.readCommand().toLowerCase();
                }
            }

        } else {
            for (int i = 0; i < currStepNumber; i++) {
                System.out.println((i + 1) + ". " + stepList.get(i).getStep());
            }
        }
    }
    public ArrayList<Step> getList() {
        return stepList;
    }

}
