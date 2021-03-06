package algorithms.search;


import java.util.LinkedList;


/**
 * This class describes the Best First Search algorithm
 */
public class BestFirstSearch extends BreadthFirstSearch {
    /**
     * This function will return the name of the searching algorithm
     *
     * @return - The name of the searching algorithm
     */
    @Override
    public String getName() {
        return "Best First Search";
    }

    /**
     * This function will add the state to the priority queue
     * @param listOfStates - The list
     * @param aState - The gicen state
     */
    protected void addToList(LinkedList<AState> listOfStates, AState aState) {
        //If the list is empty, just put the state in the list
        if (listOfStates.size() == 0) {
            listOfStates.add(aState);
            return;
        }
        //If the list is not empty, find the right location for the state
        for (int i=0; i<listOfStates.size();i++)
        {
            if(listOfStates.get(i).getPriority()<aState.getPriority())
            {
                listOfStates.add(i,aState);
                return;
            }
        }
        listOfStates.add(listOfStates.size(),aState);


    }
}