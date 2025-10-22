#define sz(v) ((int)v.size())
#define ll int
struct FT
{
	vector<int> s;
	FT(int n) : s(n) {}
	void update(int pos, int dif)
	{ // a[pos] += dif
		for (; pos < sz(s); pos |= pos + 1)
			s[pos] += dif;
	}
	ll query(int pos)
	{ // sum of values in [0, pos)
		ll res = 0;
		for (; pos > 0; pos &= pos - 1)
			res += s[pos - 1];
		return res;
	}
	int lower_bound(ll sum)
	{ // min pos st sum of [0, pos] >= sum
		// Returns n if no sum is >= sum, or -1 if empty sum is.
		if (sum <= 0)
			return -1;
		int pos = 0;
		for (int pw = 1 << 25; pw; pw >>= 1)
		{
			if (pos + pw <= sz(s) && s[pos + pw - 1] < sum)
				pos += pw, sum -= s[pos - 1];
		}
		return pos;
	}
};

class Solution {
public:

int ti = 0;
vector<vector<pair<int, int>>> adj;
vector<int> tin, tout, depth;
FT ft;
vector<int> val;

Solution() : ft(0){}
    
void dfs(int v, int par)
{
	tin[v] = ti++;
	for (auto [x, y] : adj[v])
	{
		if (x == par)
			continue;
        depth[x] = 1 + depth[v];
		val[x] = y;
		dfs(x, v);
	}

	tout[v] = ti++;
}

vector<int> treeQueries(int n, vector<vector<int>> &edges, vector<vector<int>> &queries)
{
	adj.resize(n);
	tin.resize(n);
	tout.resize(n);
	val.resize(n);
	depth.resize(n);
	for (auto &x : edges)
	{
		adj[x[0] - 1].push_back(make_pair(x[1] - 1, x[2]));
		adj[x[1] - 1].push_back(make_pair(x[0] - 1, x[2]));
	}

	ft = FT(2 * n);

	vector<int> ans;
    depth[0] = 0;
	dfs(0, -1);

	for (int i = 0; i < n; i++)
	{
		ft.update(tin[i], val[i]);
		if (tout[i] != 2*n)
			ft.update(tout[i], -val[i]);
	}
    
	for (auto &query : queries)
	{
		if (query[0] == 1)
		{
			int x = query[1], y = query[2], v = query[3];
            x--,y--;
			if (depth[x] < depth[y])
				swap(x, y);

			ft.update(tin[x], v - val[x]);
			ft.update(tout[x], val[x] - v);
			val[x] = v;
		}
		else
		{
            query[1]--;
			ans.push_back(ft.query(tin[query[1]] + 1));
		}
	}
	return ans;
}
};