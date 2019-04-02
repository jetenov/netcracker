package ru.skillbench.tasks.basics.math;

import static java.lang.Math.*;


public class ArrayVectorImpl implements ArrayVector {

    private double[] vector;




    @Override
    public void set(double... elements)  {
        this.vector = new double[elements.length];

        for (int i = 0; i < elements.length; i++) {
            this.vector[i] = elements[i];
        }
    }

    @Override
    public double[] get() {
        return vector;
    }

    /**
     * Возвращает копию вектора (такую, изменение элементов
     *  в которой не приводит к изменению элементов данного вектора).<br/>
     * Рекомендуется вызвать метод clone() у самого массива или использовать
     *   {@link System#arraycopy(Object, int, Object, int, int)}.
     */

    @Override
    public ArrayVector clone() {
    double[] cloneVector = new double[this.vector.length];
    System.arraycopy(vector, 0, cloneVector, 0, vector.length);
    ArrayVector arrayVector = new ArrayVectorImpl();
    arrayVector.set(cloneVector);
    return arrayVector;
    }

    @Override
    public int getSize() {
        return this.vector.length;
    }

    /**
     * Изменяет элемент по индексу.
     * @param index В случае выхода индекса за пределы массива:<br/>
     *  а) если index<0, ничего не происходит;<br/>
     *  б) если index>=0, размер массива увеличивается так, чтобы index стал последним.
     */

    @Override
    public void set(int index, double value) {
        if (index < 0) return;
        else if (index > vector.length - 1)  {
            double[] newVector = new double[index + 1];
            for (int i = 0; i < vector.length; i++) {
                newVector[i] = vector[i];
            }
            vector = newVector;
        }
        vector[index] = value;
    }
    /**
     * Возвращает элемент по индексу.
     * @param index В случае выхода индекса за пределы массива
     *   должно генерироваться ArrayIndexOutOfBoundsException
     */

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        return get()[index];
    }

    @Override
    public double getMax() {
        double max = get()[0];
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > max)
                max = vector[i];
        }
        return max;
    }

    @Override
    public double getMin() {
        double min = get()[0];
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] < min)
                min = vector[i];
        }

        return min;
    }

    @Override
    public void sortAscending() {
        for (int i = vector.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (vector[j] > vector[j + 1]) {
                    double tmp = vector[j];
                    vector[j] = vector[j+1];
                    vector[j+1] = tmp;
                }
            }
        }
    }

    /**
     * Умножает вектор на число.<br/>
     * Замечание: не пытайтесь использовать безиндексный цикл foreach:
     *  для изменения элемента массива нужно знать его индекс.
     * @param factor
     */

    @Override
    public void mult(double factor) {
        for (int i = 0; i < vector.length ; i++) {
            vector[i] *= factor;
        }

    }

    /**
     * Складывает вектор с другим вектором, результат запоминает в элементах данного вектора.<br/>
     * Если векторы имеют разный размер, последние элементы большего вектора не учитываются<br/>
     *  (если данный вектор - больший, его размер менять не надо, просто не меняйте последние элементы).
     * @param anotherVector Не равен null
     * @return Ссылка на себя (результат сложения)
     */

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {

        for (int i = 0; i < vector.length; i++) {
            vector[i] += anotherVector.get(i);
        }
        return this;
    }

    /**
     * Возвращает скалярное произведение двух векторов.<br/>
     * Если векторы имеют разный размер, последние элементы большего вектора не учитываются.
     * @param anotherVector Не равен null
     */

    @Override
    public double scalarMult(ArrayVector anotherVector) {
        double scalarMult = 0;
        for (int i = 0; i < vector.length ; i++) {
            scalarMult += (vector[i] * anotherVector.get(i));
        }
        return scalarMult;
    }

    /**
     * Возвращает евклидову норму вектора (длину вектора
     *  в n-мерном евклидовом пространстве, n={@link #getSize()}).
     * Это можно подсчитать как корень квадратный от скалярного произведения вектора на себя.
     */

    @Override
    public double getNorm() {
        return Math.sqrt(this.scalarMult(this));
    }
}
