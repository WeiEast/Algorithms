package leetCode;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.

Credits:
Special thanks to @mithmatt for adding this problem, creating the above image and all test cases.
 *
 */
public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int minX = Math.max(A, E);
		int minX2 = Math.min(C, G);

		int minY = Math.max(B, F);
		int minY2 = Math.min(D, H);
		int abs = minX2 - minX;
		int abs2 = minY2 - minY;

		if (minX2 <= minX || minY2 <= minY) {
			return (D - B) * (C - A) + (G - E) * (H - F);
		}
		return (D - B) * (C - A) + (G - E) * (H - F) - abs * abs2;
	}
}
