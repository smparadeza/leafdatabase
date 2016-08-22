package app.dao;


import app.GenericDao.GenericDao;
import app.domain.Leaf;

import java.util.List;

public interface LeafDao extends GenericDao<Leaf, Long> {
    Leaf getUnlabeledEntry();
    Leaf getNextEntry(Leaf leaf);
    Leaf getPreviousEntry(Leaf leaf);
    Leaf markAsCompound(Leaf leaf);
    Leaf markAsSimple(Leaf leaf);

    List getCompoundLeaves();

}