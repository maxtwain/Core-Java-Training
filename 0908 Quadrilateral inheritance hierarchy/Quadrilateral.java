public class Quadrilateral{
	private Point[] pointSet = new Point[4];
	
	// This constructor reorganizes the pointSet in the case of a poorly ordered set.  This makes it somewhat possible to use random number generation to get the points of a shape.  The only issue I foresee is that a concave object might not give good area data, but this could be remedied with more work on this project.
	public Quadrilateral(Point[] pointSet) {
		Point midpoint = getMidpoint();
		for (int i = 0; i < 4; ++i) {
			if (pointSet[i] == midpoint) {
				throw new IllegalArgumentException("midpoint == pointSet[i]");
			}
		}
		
		// angles from midpoint to pointSet elements recorded
		double[] angle = new double[4];
		for (int i = 0; i < 4; ++i) {
			angle[i] = pointSet[i].getAngle(midpoint);
		}
		mergeSort(angle, pointSet, 0, angle.length - 1);
		
		this.pointSet = pointSet;
	}
	
	private void mergeSort(double[] angle, Point[] mainSet, int left, int right) {
		if (left < right) {
			int middle = left + (right - left) / 2;
			mergeSort(angle, mainSet, left, middle);
			mergeSort(angle, mainSet, middle + 1, right);
			
			sort(angle, mainSet, left, middle, right);
		}
	}
	private void sort(double[] angle, Point[] mainSet, int left, int mid, int right) {
		int size0 = mid - left + 1;
		int size1 = right - mid;
		
		double[] arr0 = new double[size0];
		double[] arr1 = new double[size1];
		Point[] set0 = new Point[size0];
		Point[] set1 = new Point[size1];
		for (int i = 0; i < size0; ++i) {
			arr0[i] = angle[left + i];
			set0[i] = mainSet[left + i];
		}
		for (int i = 0; i < size1; ++i) {
			arr1[i] = angle[mid + 1 + i];
			set1[i] = mainSet[mid + 1 + i];
		}
		
		int sourceIndex = left;
		int i0 = 0;
		int i1 = 0;
		for (; i0 < size0 && i1 < size1; ++sourceIndex) {
			if (arr0[left] <= arr1[right]) {
				angle[sourceIndex] = arr0[i0];
				mainSet[sourceIndex] = set0[i0];
				++i0;
			}
			else {
				angle[sourceIndex] = arr1[i1];
				mainSet[sourceIndex] = set1[i1];
				++i1;
			}
		}
		
		for (; i0 < size0; ++i0, ++sourceIndex) {
			angle[sourceIndex] = arr0[i0];
			mainSet[sourceIndex] = set0[i0];
		}
		for (; i1 < size1; ++i1, ++sourceIndex) {
			angle[sourceIndex] = arr1[i1];
			mainSet[sourceIndex] = set1[i1];
		}
	}
	
	public Point[] getPointSet() {
		return pointSet;
	}
	public Point getPoint(int index) {
		return pointSet[index];
	}
	
	public double area() {
		double a = pointSet[0].distance(pointSet[1]);
		double b = pointSet[1].distance(pointSet[2]);
		double c = pointSet[2].distance(pointSet[3]);
		double d = pointSet[3].distance(pointSet[0]);
		
		double p = pointSet[1].distance(pointSet[3]);
		double q = pointSet[0].distance(pointSet[2]);
		
		double diag = Math.pow(p, 2) * Math.pow(q, 2);
		double side = Math.pow(b, 2) + Math.pow(d, 2) - Math.pow(a, 2) - Math.pow(c, 2);
		
		return 1.0 / 4.0 * Math.sqrt(4 * diag - Math.pow(side, 2));
	}
	
	private Point getMidpoint() {
		double x = 0;
		double y = 0;
		for (int i = 0; i < 4; ++i) {
			x += pointSet[i].getX();
			y += pointSet[i].getY();
		}
		x /= 4;
		y /= 4;
		
		Point mid = new Point(x, y);
		return mid;
	}
	
	public double getBaseLength() {
		int i = 0;
		Point lowest = pointSet[i];
		for (++i; i < 4; ++i) {
			if (pointSet[i].getY() < lowest.getY()) {
				lowest = pointSet[i];
			}
		}
		
		++i;
		if (i > 3) {
			i -= 4;
		}
		Point low = pointSet[i];
		i -= 2;
		if (i < 0) {
			i += 4;
		}
		if (pointSet[i].getY() < low.getY()) {
			low = pointSet[i];
		}
		return lowest.distance(low);
	}
	public double getBaseSlope() {
		int i = 0;
		Point lowest = pointSet[i];
		for (++i; i < 4; ++i) {
			if (pointSet[i].getY() < lowest.getY()) {
				lowest = pointSet[i];
			}
		}
		
		++i;
		if (i > 3) {
			i -= 4;
		}
		Point low = pointSet[i];
		i -= 2;
		if (i < 0) {
			i += 4;
		}
		if (pointSet[i].getY() < low.getY()) {
			low = pointSet[i];
		}
		return (low.getY() - lowest.getY()) / (low.getX() - lowest.getX());
	}
	public double getHeightLength() {
		int i0 = 0;
		Point lowest = pointSet[i0];
		for (++i0; i0 < 4; ++i0) {
			if (pointSet[i0].getY() < lowest.getY()) {
				lowest = pointSet[i0];
			}
		}
		
		int i1 = i0 + 1;
		if (i1 > 3) {
			i1 -= 4;
		}
		Point low = pointSet[i1];
		i1 -= 2;
		if (i1 < 0) {
			i1 += 4;
		}
		if (pointSet[i1].getY() < low.getY()) {
			low = pointSet[i1];
		}
		
		int high;
		if (i0 > i1) {
			high = i1 - 1;
			if (i1 == -1) {
				i1 += 4;
			}
		}
		else {
			high = i1 + 1;
			if (i1 == 4) {
				i1 -= 4;
			}
		}
		double hypSlope = (pointSet[high].getY() - pointSet[i1].getY()) / (pointSet[high].getX() - pointSet[i1].getX());
		
		
		return 0;
	}
}