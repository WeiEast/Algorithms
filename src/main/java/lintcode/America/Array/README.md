#数组partition的题目

给出一个整数数组nums和一个整数k。划分数组（即移动数组nums中的元素），使得： 

所有小于k的元素移到左边
所有大于等于k的元素移到右边
返回数组划分的位置，即数组中第一个位置i，满足nums[i]大于等于k。 

典型的partition题目: 类似快速排序 , 找到一个哨兵 然后两个指针一个从头一个从尾部 


头指针 i 向后走 , 条件为 nums[i]<k && i<j  表示从头走直到k>=nums[i]的时候停下 , 然后就是需要交换的值

此时尾指针向前走 , 条件为nums[j]>=k && i<j 表示从尾走直到找到第一个 nums[i]<k这个元素将会与上一个i进行交换

swap过程 , 如此就完成一趟快速排序

private int mySolution(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        for (int i = 0, j = nums.length - 1; i < j; i++, --j) {
            for (; i < j && nums[i] < k; i++)
                ;
            for (; i < j && nums[j] >= k; j--)
                ;
            if (i < j)
                swap(nums, i, j);
        }
        for (int m = 0; m < nums.length; m++) {
            if (k <= nums[m])
                return m;
        }
        return nums.length;
    }
private void swap(int[] nums, int i, int j) {
	int temp = nums[i];
	nums[i] = nums[j];
	nums[j] = temp;
}