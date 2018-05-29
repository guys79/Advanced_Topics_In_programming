package Server;

import IO.MyCompressorOutputStream;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;

import java.io.*;

/**
 * This class is the implementation of the Generate maze strategy
 */
public class ServerStrategyGenerateMaze implements IServerStrategy {


    /**
     *This function is the actual implementation of the strategy
     * @param inFromClient - The input stream
     * @param outToClient - The output stream
     */
    @Override
    public void serverStrategy(InputStream inFromClient, OutputStream outToClient) {

        try {
            //Creating the I/O streams
            ObjectInputStream fromClient = new ObjectInputStream(inFromClient);
            MyCompressorOutputStream toClient=new MyCompressorOutputStream(outToClient);
            toClient.flush();

            //The size of the Maze
            int []a=(int []) fromClient.readObject();

            //Generating the maze
            MyMazeGenerator mg=new MyMazeGenerator();
            Maze maze=mg.generate(a[0],a[1]);

            //Sending the maze via the compression output stream
            toClient.write(maze.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
