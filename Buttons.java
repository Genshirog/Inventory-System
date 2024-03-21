import javax.swing.*;

public abstract class Buttons {
    public abstract void OnClick();
    public abstract JButton ButtonDisplay();
    public abstract JButton add();
    public abstract JButton search();
    public abstract JButton update();
    public abstract JButton delete();
    public abstract JPanel addbody();
    public abstract JPanel searchbody();
    public abstract JPanel updatebody();
    public abstract JPanel deletebody();
    public abstract JButton clear();
}
