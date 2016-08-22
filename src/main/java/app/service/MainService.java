package app.service;

import app.domain.Leaf;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MainService {
    Leaf getLeafById(Long id);
    void saveLeaf(Leaf leaf);
    List getAllLeaves();
    Leaf getUnlabeledLeaf();
    Leaf getNextLeaf(Leaf leaf);
    Leaf getPreviousLeaf(Leaf leaf);
    Leaf markAsCompound(Leaf leaf);
    Leaf markAsSimple(Leaf leaf);

    List getCompoundLeavesNames();
    List getCompoundLeafImages(String leafName);

}
