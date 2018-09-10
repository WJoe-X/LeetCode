package Collection;
import java.util.PriorityQueue;

/**
 * @auther: WJoe
 * @Description:
 * @Date : 20:28 2018/8/26
 */
public class KthLargest {

        private PriorityQueue<Integer> queue;

        private  int k;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.queue = new PriorityQueue<Integer>(k);
            for (int i = 0; i < nums.length; i++) {
                this.queue.add(nums[i]);
            }
          if (nums.length>k){
                for (int  i= 0; i <nums.length-k ; i++) {
                    this.queue.remove();
                }
            }
        }
        public int add(int val) {
                  this.queue.add(val);
                  if (this.queue.size()>k)
                      this.queue.remove();
                  return this.queue.peek();
        }


}
