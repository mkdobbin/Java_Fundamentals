import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int count = 0;
        for(Point currPt : s.getPoints()) {
            count++;
        }// Put code here
        return count;
    }

    public double getAverageLength(Shape s) {
        double totalPerimeter = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double avgLength = totalPerimeter / numPoints;
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        Point previousPoint = null;
        double maxLength = 0;
        for(Point currentPoint : s.getPoints()){
            if(previousPoint != null){
                double length = previousPoint.distance(currentPoint);
                if(length > maxLength){
                    maxLength = length;
                }
            }
            previousPoint = currentPoint;
        }         
        return maxLength;
    }

    public double getLargestX(Shape s) {
        double maxX = 0;
        for(Point currentPoint : s.getPoints()){
            double currentX = currentPoint.getX();
            if(currentX > maxX) {
                maxX = currentX;
            }
        }
        return maxX;
    }

    public double getLargestPerimeterMultipleFiles() {
        double largestPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        FileResource fr = null;
        for(File f : dr.selectedFiles()){
            FileResource file = new FileResource(f);
            Shape s = new Shape(file);
            double peri = getPerimeter(s);
            if(peri>largestPerimeter){
                largestPerimeter = peri;
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        File largestFile = null;
        
        for(File f : dr.selectedFiles()){
            FileResource file = new FileResource(f);
            Shape shape = new Shape(file);
            double perim = getPerimeter(shape);
            if(perim > largestPerim){
                largestPerim = perim;
                largestFile = f;
            }
        }
        
        return largestFile.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numPoints = getNumPoints(s);
        System.out.println("Number of points = " + numPoints);
        double avgLength = getAverageLength(s);
        System.out.println("Average Length = " + avgLength);
        double maxLength = getLargestSide(s);
        System.out.println("Largest side = " + maxLength);
        double maxX = getLargestX(s);
        System.out.println("Maximum x position = " + maxX);

    }
    
    public void testPerimeterMultipleFiles() {
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter in the files = " + largestPerimeter);// Put code here
    }

    public void testFileWithLargestPerimeter() {
        String fileName = getFileWithLargestPerimeter();
        System.out.println("The largest perimeter in the directory = " + fileName);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
