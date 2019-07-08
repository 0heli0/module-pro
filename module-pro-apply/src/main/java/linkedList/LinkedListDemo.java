package linkedList;

import java.util.Arrays;

public class LinkedListDemo {

    public static void main(String[] args) {
        /*NodeDemoList list = new NodeDemoList();
        NodeDemo node1 = new NodeDemo(1,"1","第一个");
        NodeDemo node2 = new NodeDemo(2,"2","第二个");
        NodeDemo node3 = new NodeDemo(3,"3","第三个");
        list.addOrder(node1);
        list.addOrder(node3);
        list.addOrder(node3);
        list.addOrder(node2);
        list.append(node1);
        list.append(node3);
        list.append(node3);
        list.append(node2);

        list.list();*/
        int[] arry = new int[5];
       /* for (int i = 0; i < arry.length; i++) {
            arry[i] = i+1;
        }
        System.err.println(Arrays.toString(arry));*/
        System.err.println(getResult(100,1,3));


    }

    /**
     *
     * @param n  一共有多少个人 报数
     * @param start 从第几个开始报数
     * @param step	报数的步长
     * @return
     */
    public static int getResult(int n,int start,int step){
        // 先判断参数规则
        if(n <= 0 || start <= 0 || step <= 0){
            return 0;
        }
        if(n < start){
            return  0;
        }

        int[] all=null;
        int[] all2=null;
        //初始化这个队列
        if(all==null){
            all=new int[n];
            all2=new int[n];
            for(int i=0;i<n;i++){
                all[i]=i+1;
                all2[i] = i;
            }
        }

        System.out.println(Arrays.toString(all2));
        // 计算开始报数位置
        int startIndex = (start - 1)%n;

        while (all[1] != 0){
            // 计算被取出位置

            int removeIndex = (startIndex  + step - 1)%n;
//            System.out.println(removeIndex);
            System.err.println(Arrays.toString(all));

            // 取出该值
            startIndex = removeIndex;
            while (removeIndex < n-1){
                all[removeIndex] = all[removeIndex+1];
                removeIndex++;
            }
            all[--n] = 0;

        }

        return all[0];
    }

}
class NodeDemoList{
    private NodeDemo head = new NodeDemo(0,"","");

    public NodeDemo getHead(){
        return this.head;
    }

    // 添加到最后
    public void append(NodeDemo node){
        NodeDemo temp = head;
        while (true){
            if(temp.next == null){
                temp.next = node;
                break;
            }else if (temp.next == node){
                System.err.printf("不能重复添加,节点%d已经存在\n",node.no);
                break;
            }
            // 指针后移
            temp = temp.next;
        }
    }

    // 按照顺序添加
    public void addOrder(NodeDemo node){
        NodeDemo temp = head;
        while (true){
            if(temp.next == null){
                temp.next = node;
                break;
            }else if(temp.next.no > node.no){
                node.next = temp.next;
                temp.next = node;
                break;
            }else if(temp.next.no == node.no){
                System.err.printf("已存在序号为%d的节点\n",node.no);
                break;
            }
            temp = temp.next;
        }
    }


    // 遍历
    public void list(){
        NodeDemo temp = head.next;
        while (true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }
}

class NodeDemo{
    // 序号
    public int no;
    // 键
    public String key;
    // 值
    public String value;
    // 下个节点
    public NodeDemo next;

    public NodeDemo(int no, String key, String value){
        this.no = no;
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "NodeDemo{" +
                "no=" + no +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}