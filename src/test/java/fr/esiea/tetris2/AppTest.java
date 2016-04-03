package fr.esiea.tetris2;

import org.junit.Assert;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    public class PieceObjectServiceTest {
    	
    	public void Doit_Creer_Une_Piece_Et_La_tourner(){
    		boolean test = true;
    		int[][][] tab1 = new int[][][] {{{0,1,0,0},{0,1,1,0},{0,0,1,0},{0,0,0,0}},
    			   {{0,0,1,1},{0,1,1,0},{0,0,0,0},{0,0,0,0}},
    			{{0,1,0,0},{0,1,1,0},{0,0,1,0},{0,0,0,0}},
    			{{0,0,1,1},{0,1,1,0},{0,0,0,0},{0,0,0,0}}};
    			
    			int [][] max1= new int[][] {{2,2},{1,3},{2,2},{1,3}};
        	   	int [][] min1= new int[][] {{0,1},{0,1},{0,1},{0,1}};
        	   	int orientat=0;
        	   	
    		Piece1 piece = new Piece1(orientat , tab1,max1,min1);
    		Grille g = new Grille();
    		int [][] s=g.Gril();
    		int [][] pieceafterREll={{0,1,0,0},{0,1,1,0},{0,0,1,0},{0,0,0,0}};
    		int[][] pieceafter=piece.rotationt(orientat, 100, 100, s);
    		for(int i=0;i<4;i++){
    			for(int j=0;j<4;j++){
    				test=test&pieceafterREll[i][j]==pieceafter[i][j];
    			}
    		
    		}
    	
    		Assert.assertTrue(test);
    }
    }
    
    
    
    
    
}
