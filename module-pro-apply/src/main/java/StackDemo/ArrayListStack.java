package StackDemo;

public class ArrayListStack {
    public static void main(String[] args) {
        // 2+5*(12-10)+6-5
        StackDemo stack = new StackDemo(5);
        stack.push("100");
        stack.push("200");
        stack.push("300");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push("300");
        stack.list();
    }
}

class StackDemo{
    public String[] array; // 值
    public int top = -1;// 栈顶
    public int buttom = -1;// 栈底
    public int maxLength;// 最大长度

    private StackDemo(){

    }

    /**
     * 初始化
     * @param maxLength
     */
    public StackDemo(int maxLength){
        if(maxLength <= 0){
            System.err.println("最大长度必须大于0");
            return;
        }
        this.maxLength = maxLength;
        array = new String[this.maxLength];
    }

    /**
     * 入栈
     * @param value
     */
    public void push(String value){
        if(this.maxLength - 1 <= this.top ){
            System.err.println("栈空间已经满了");
            return;
        }
        this.top++;
        this.array[top] = value;
    }

    /**
     * 出栈
     * @return
     */
    public String pop(){
        if(this.top == this.buttom){
            System.err.println("该栈为空");
            return null;
        }
        String temp = array[top];
        top--;
        return temp;
    }

    /**
     * 打印栈
     */
    public void list(){
        if(top == buttom){
            System.err.println("该栈为空");
        }
        for (int i = top; i >= 0 ; i--) {
            System.err.printf("栈列表为:%s\n",array[i]);
        }
    }

    /**
     * 展示栈顶元素
     * @return
     */
    public String top(){
        if(top == buttom){
            System.err.println("空栈");
            return null;
        }
        return array[top];
    }
}
