package day01;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class LabeledPoint implements Serializable {

    private static final long serialVersionUID = -4274620002761121815L;
    private String label;
    private transient Point2D.Double point;

    LabeledPoint(String label, Point2D.Double point) {
        this.label = label;
        this.point = point;
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        //�÷���ֻ���ڿ����л����readObject�����е���
        in.defaultReadObject();
        double x = in.readDouble();
        double y = in.readDouble();
        point = new Point2D.Double(x, y);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        //�÷���ֻ���ڿ����л����writeObject������ʹ��
        out.defaultWriteObject();
        out.writeDouble(point.getX());
        out.writeDouble(point.getY());
    }

    @Override
    public String toString() {
        return "LabeledPoint{" +
                "label='" + label + '\'' +
                ", point=" + point +
                '}';
    }
}
