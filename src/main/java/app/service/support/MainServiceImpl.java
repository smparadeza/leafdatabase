package app.service.support;

import app.dao.LeafDao;
import app.domain.Leaf;
import app.service.MainService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@Service
public class MainServiceImpl implements MainService {
    private LeafDao leafDao;

    @Override
    public Leaf getLeafById(Long id) {
        return leafDao.find(new Leaf(), id);
    }

    @Override
    public void saveLeaf(Leaf leaf) {
        this.leafDao.create(leaf);
    }

    @Override
    public List getAllLeaves() {
        return this.leafDao.findAll(new Leaf());
    }

    @Override
    public Leaf getUnlabeledLeaf() {
        return leafDao.getUnlabeledEntry();
    }

    @Override
    public Leaf getNextLeaf(Leaf leaf) {
        return leafDao.getNextEntry(leaf);
    }

    @Override
    public Leaf getPreviousLeaf(Leaf leaf) {
        return leafDao.getPreviousEntry(leaf);
    }

    @Override
    public Leaf markAsCompound(Leaf leaf) {
        return leafDao.markAsCompound(leaf);
    }

    @Override
    public Leaf markAsSimple(Leaf leaf) {
        return leafDao.markAsSimple(leaf);
    }

    @Override
    public List getCompoundLeavesNames() {
        List<Leaf> leaves = new ArrayList<Leaf>();
        leaves = leafDao.getCompoundLeaves();
        HashSet<String> names = new HashSet<>();
        for (Leaf l : leaves) {
            names.add(l.getVernacularName());
        }
        List<String> leavesNames = new ArrayList<String>(names);
        return leavesNames;
    }

    @Override
    public List getCompoundLeafImages(String leafName) {
        List<String> images = new ArrayList<>();
        List<Leaf> leaves = leafDao.getCompoundLeaves();
        for(Leaf l : leaves){
            if(l.getVernacularName().toLowerCase().equals(leafName.toLowerCase())) {
                images.add(l.getFilename());
            }
        }
        return images;
    }

    public LeafDao getLeafDao() {
        return leafDao;
    }

    public void setLeafDao(LeafDao leafDao) {
        this.leafDao = leafDao;
    }
}
