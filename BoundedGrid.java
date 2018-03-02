
import java.util.List;
import java.util.ArrayList;

// A BoundedGrid is a rectangular grid with a finite number of rows and columns.
public class BoundedGrid<E>
{
	private Object[][] occupantArray;  // the array storing the grid elements

	// Constructs an empty BoundedGrid with the given dimensions.
	// Precondition:  0 < rows and 0 < cols.
	public BoundedGrid(int rows, int cols)
	{
		occupantArray = new Object[rows][cols];
	}

	// Returns the number of rows.
	public int getNumRows()
	{
		return occupantArray.length;
	}

	// Returns the number of columns.
	public int getNumCols()
	{
		return occupantArray[0].length;
	}

	// Returns the object at location loc
	// (or null if the location is unoccupied).
	// Precondition:  loc is valid in this grid.
	@SuppressWarnings("unchecked")
	public E get(Location loc)
	{
		return (E)occupantArray[loc.getRow()][loc.getCol()];
	}

	// Puts obj at location loc in this grid and returns the object previously
	// at that location (or null if the location is unoccupied).
	// Precondition:  loc is valid in this grid.
	public E put(Location loc, E obj)
	{
		E oldOccupant = get(loc);
		occupantArray[loc.getRow()][loc.getCol()] = obj;
		return oldOccupant;
	}

	// Returns true if loc is valid in this grid, false otherwise.
	// Precondition:  loc is not null.
	public boolean isValid(Location loc)
    {
        return(loc.getRow() >= 0 && loc.getRow() < this.getNumRows() && loc.getCol() >= 0 && loc.getCol() < this.getNumCols());
    }

	// Removes the object at location loc from this grid and returns
	// the object that was removed (or null if the location is unoccupied).
	// Precondition:  loc is valid in this grid.
	public E remove(Location loc)
	{
	        E r = get(loc);
	        occupantArray[loc.getRow()][loc.getCol()] = null;
	        return r;
	}

	// Returns a list of all occupied locations in this grid.
	public List<Location> getOccupiedLocations()
	{
		 ArrayList<Location> theLocations = new ArrayList<Location>();
	        
	        for (int i = 0; i < getNumRows(); i++)
	        {
	        	for (int j = 0; j < getNumCols(); j++)
	        	{
	        		if (occupantArray[i][j] != null)
	        		{
	        			Location l = new Location(i,j);
	        			theLocations.add(l);
	        		}
	        	}
	        }

	        return theLocations;
	}
}
