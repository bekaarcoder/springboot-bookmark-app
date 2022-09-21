import Link from "next/link";
import moment from "moment";

const Bookmark = ({ bookmark }) => {
    return (
        <div className="card text-bg-light mb-3">
            <div className="card-body d-flex justify-content-between">
                <Link href={bookmark.url}>
                    <a className="text-decoration-none" target={"_blank"}>
                        {bookmark.title}
                    </a>
                </Link>
                <span>{moment(bookmark.createdAt).fromNow()}</span>
            </div>
        </div>
    );
};

export default Bookmark;
