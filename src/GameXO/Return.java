package GameXO;
//class này để lưu lại vị trí ô vừa mới đánh (phục vụ cho chức năng đánh lại)
public class Return {
    private int x;
    private int y;

    public Return(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Return() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
