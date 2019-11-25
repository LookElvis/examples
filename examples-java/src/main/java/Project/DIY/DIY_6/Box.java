package Project.DIY.DIY_6;

/**
 * Created by liuxiang on 2018/7/9.
 */
class Box<O> {

    private O data;

    public Box() {

    }

    public Box(O data) {
        setData(data);
    }

    public O getData() {
        return data;
    }

    public void setData(O data) {
        this.data = data;
    }

}
