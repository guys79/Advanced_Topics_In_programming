package algorithms.search;
import algorithms.mazeGenerators.*;
//
public class SearchableMaze implements ISearchable {

    private AState start,goal;
    //this function will make the graph out of an array of maze states
    private void makeGraph(MazeState[][] maze){
        //we go over all the array cheack for every cell if there is a MazeState there and if so we comunicate him with al, his neibhors
        for (int i = 0; i < maze.length;i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if(maze[i][j]!=null){
                    //this is in a case that we have a neighbor that is upper by 1 step from us
                    if(i-1>=0){
                        if(maze[i-1][j]!=null){
                            maze[i][j].addPossilbleState(maze[i-1][j]);

                        }
                    }
                    //this is in a case that we have a neighbor that is lower by 1 step from us
                    if(i+1<maze.length){
                        if(maze[i+1][j]!=null){
                            maze[i][j].addPossilbleState(maze[i+1][j]);
                        }
                    }
                    //this is in a case that we have a neighbor that is left by 1 step from us
                    if(j-1>=0){
                        if(maze[i][j-1]!=null){
                            maze[i][j].addPossilbleState(maze[i][j-1]);
                        }
                    }
                    //this is in a case that we have a neighbor that is right by 1 step from us
                    if(j+1<maze[0].length){
                        if(maze[i][j+1]!=null){
                            maze[i][j].addPossilbleState(maze[i][j+1]);
                        }
                    }
                    //this is in a case that we have a neighbor that is upper by 1 step from us and left by 1 step from us
                    if(i-1>=0&&j-1>=0){
                        if(maze[i-1][j-1]!=null){
                            maze[i][j].addPossilbleState(maze[i-1][j-1]);
                        }
                    }
                    //this is in a case that we have a neighbor that is lower by 1 step from us and left by 1 step from us
                    if(i+1<maze.length&&j-1>=0){
                        if(maze[i+1][j-1]!=null){
                            maze[i][j].addPossilbleState(maze[i+1][j-1]);
                        }
                    }
                    //this is in a case that we have a neighbor that is lower by 1 step from us and right by 1 step from us
                    if(j+1<maze[0].length&&i+1<maze.length){
                        if(maze[i+1][j+1]!=null){
                            maze[i][j].addPossilbleState(maze[i+1][j+1]);
                        }
                    }
                    //this is in a case that we have a neighbor that is upper by 1 step from us and right by 1 step from us
                    if(j+1<maze[0].length&&i-1>=0){
                        if(maze[i-1][j+1]!=null){
                            maze[i][j].addPossilbleState(maze[i-1][j+1]);
                        }
                    }
                }
            }
        }
    }

    public SearchableMaze(Maze maze)
    {
        //we initilize the start and goal
        //we initilize the array of mazeStates by nulles
        MazeState[][] mazeOfStates= new MazeState[maze.getNumOfRows()][maze.getNumOfColumns()];
        for (int i = 0; i < maze.getNumOfRows();i++) {
            for (int j = 0; j < maze.getNumOfColumns(); j++) {
                mazeOfStates[i][j]=null;
            }
        }
        //we create for every pass a Maze State
        for (int i = 0; i < maze.getNumOfRows();i++) {
            for (int j = 0; j < maze.getNumOfColumns();j++) {
                if (maze.ifThereIsAPass(i, j)) {
                 mazeOfStates[i][j]=new MazeState(new Position(i, j));
                }
            }
        }
        //we make the graph(the conection beetwen every two neibhors)
        makeGraph(mazeOfStates);
        this.start= mazeOfStates[maze.getStartPosition().GetRowIndex()][maze.getStartPosition().GetColumnIndex()];
        this.goal= mazeOfStates[maze.getGoalPosition().GetRowIndex()][maze.getGoalPosition().GetColumnIndex()];
    }
    public SearchableMaze(AState start,AState end)
    {
        this.start=start;
        this.goal=end;

    }
    public AState getStartState()
    {
        return this.start;
    }
    public AState getGoalState()
    {
        return this.goal;
    }
}
