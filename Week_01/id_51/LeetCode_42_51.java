public class TrapWater {

    private static Function<Integer[], Integer> stackSolution = height -> {
        if (height == null || height.length == 0) return 0;
        Stack<Integer> s = new Stack<>();

        int result = 0;
        for (int current = 0; current < height.length; current++) {
            while (!s.isEmpty() && height[current] >= height[s.peek()]) {
                int top = s.pop();
                if (s.isEmpty()) continue;
                int squareHeight = Math.min(height[current], height[s.peek()]) - height[top];
                int squareWidth = current - s.peek() - 1;
                result += squareHeight * squareWidth;
            }
            s.push(current);
        }

        return result;

    };

    private static Function<Integer[], Integer> dynamicProgramming = height -> {
        if (height == null || height.length == 0) return 0;
        int result = 0;
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];

        leftMax[0] = height[0];
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        rightMax[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        for (int i = 0; i < size-1; i++) {
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return result;
    };

    private static Function<Integer[], Integer> twoPointer = height -> {
        if (height == null || height.length == 0) return 0;
        int result = 0;
        int size = height.length;
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = size - 1;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    result += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    result += rightMax - height[right];
                }
                right--;
            }
        }

        return result;
    };



    public static void main(String[] args) {
        int trap1 = stackSolution.apply(new Integer[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        int trap2 = dynamicProgramming.apply(new Integer[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        int trap3 = twoPointer.apply(new Integer[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap1);
        System.out.println(trap2);
        System.out.println(trap3);
    }


}
