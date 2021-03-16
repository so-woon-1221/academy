class MyStack<T> {
    int tos;
    Object[] stck;

    public MyStack() {
        tos = 0;
        stck = new Object[10];
    }

    public void push(T item) {
        if (tos == 10)
            return;
        stck[tos] = item;
        tos++;
    }

    public T pop() {
        if (tos == 0)
            return null;
        tos--;
        return (T) stck[tos];
    }
}

public class GStack {
    public static void main(String[] args) {
        MyStack<String> stringMyStack = new MyStack<>();

        stringMyStack.push("seoul");
        stringMyStack.push("busan");
        stringMyStack.push("LA");

        for (int n = 0; n < 3; n++) {
            System.out.println(stringMyStack.pop());
        }

        MyStack<Integer> integerMyStack = new MyStack<>();

        integerMyStack.push(1);
        integerMyStack.push(3);
        integerMyStack.push(5);

        for (int i = 0; i < 3; i++) {
            System.out.println(integerMyStack.pop());
        }
    }
}
