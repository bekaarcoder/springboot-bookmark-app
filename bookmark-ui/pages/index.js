import Bookmarks from "../components/Bookmarks";
import SearchForm from "../components/SearchForm";
import { fetchBookmarks } from "../services/api";

export default function Home({ bookmarks }) {
    return (
        <div className="container">
            <div className="row mt-4">
                <div className="col-md-12">
                    <h1 className="text-center">
                        Save interesting stories in your bucket.
                    </h1>
                    <SearchForm />
                    <Bookmarks bookmarks={bookmarks} />
                </div>
            </div>
        </div>
    );
}

export const getServerSideProps = async (context) => {
    const { page = 1 } = context.query;
    const bookmarks = await fetchBookmarks(parseInt(page));
    return {
        props: {
            bookmarks: bookmarks,
        },
    };
};
